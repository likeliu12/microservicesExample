package conrurrent.forkjoin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class RecursiveActionDemo extends RecursiveAction {
	private static final long serialVersionUID = 1614364763877307687L;
	private String workLoad = "";
	private static final int THRESHOLD = 100;

	private static Logger logger = Logger.getAnonymousLogger();

	public RecursiveActionDemo(String workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected void compute() {
		if (workLoad.length() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubtasks());
		} else {
			processing(workLoad);
		}
	}

	private Collection<RecursiveActionDemo> createSubtasks() {

		List<RecursiveActionDemo> subtasks = new ArrayList<>();

		String partOne = workLoad.substring(0, workLoad.length() / 2);
		String partTwo = workLoad.substring(workLoad.length() / 2 + 1,
				workLoad.length());

		subtasks.add(new RecursiveActionDemo(partOne));
		subtasks.add(new RecursiveActionDemo(partTwo));

		return subtasks;
	}

	private void processing(String work) {
		String result = work.toUpperCase();
		logger.info("This result - (" + result + ") - was processed by "
				+ Thread.currentThread().getName());
	}
	public static void main(String[] args) {
	    
	 
	    // submit the task to the pool
	    final ForkJoinPool pool = PoolUtil.forkJoinPool;
	    String str = "A ForkJoinTask is a lightweight form of Future. The efficiency of ForkJoinTasks stems from a set of restrictions (that are only partially statically enforceable) reflecting their main use as computational tasks calculating pure functions or operating on purely isolated objects. The primary coordination mechanisms are fork(), that arranges asynchronous execution, and join(), that doesn't proceed until the task's result has been computed. Computations should ideally avoid synchronized methods or blocks, and should minimize other blocking synchronization apart from joining other tasks or using synchronizers such as Phasers that are advertised to cooperate with fork/join scheduling. Subdividable tasks should also not perform blocking I/O, and should ideally access variables that are completely independent of those accessed by other running tasks. These guidelines are loosely enforced by not permitting checked exceptions such as IOExceptions to be thrown. However, computations may still encounter unchecked exceptions, that are rethrown to callers attempting to join them. These exceptions may additionally include RejectedExecutionException stemming from internal resource exhaustion, such as failure to allocate internal task queues. Rethrown exceptions behave in the same way as regular exceptions, but, when possible, contain stack traces (as displayed for example using ex.printStackTrace()) of both the thread that initiated the computation as well as the thread actually encountering the exception; minimally only the latter.It is possible to define and use ForkJoinTasks that may block, but doing do requires three further considerations: (1) Completion of few if any other tasks should be dependent on a task that blocks on external synchronization or I/O. Event-style async tasks that are never joined (for example, those subclassing CountedCompleter) often fall into this category. (2) To minimize resource impact, tasks should be small; ideally performing only the (possibly) blocking action. (3) Unless the ForkJoinPool.ManagedBlocker API is used, or the number of possibly blocked tasks is known to be less than the pool's ForkJoinPool.getParallelism() level, the pool cannot guarantee that enough threads will be available to ensure progress or good performance.The primary method for awaiting completion and extracting results of a task is join(), but there are several variants: The Future.get() methods support interruptible and/or timed waits for completion and report results using Future conventions. Method invoke() is semantically equivalent to fork(); join() but always attempts to begin execution in the current thread. The \"quiet\" forms of these methods do not extract results or report exceptions. These may be useful when a set of tasks are being executed, and you need to delay processing of results or exceptions until all complete. Method invokeAll (available in multiple versions) performs the most common form of parallel invocation: forking a set of tasks and joining them all.";
	    final RecursiveActionDemo finder = new RecursiveActionDemo(str);
	    System.out.println(pool.invoke(finder));
	  }
}
