package conrurrent.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
	private static final long serialVersionUID = -8448550391765000096L;

	private int[] data;

	private static final int THRESHOLD = 20;

	public CustomRecursiveTask(int[] data) {
		this.data = data;
	}

	@Override
	protected Integer compute() {

		if (data.length > THRESHOLD) {

			return ForkJoinTask.invokeAll(createSubtasks()).stream()
					.mapToInt(ForkJoinTask::join).sum();

		} else {
			return processing(data);
		}
	}

	private Collection<CustomRecursiveTask> createSubtasks() {
		List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
		dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(data, 0,
				data.length / 2)));
		dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(data,
				data.length / 2 + 1, data.length)));
		return dividedTasks;
	}

	private Integer processing(int[] arr) {
		return Arrays.stream(arr).filter(a -> a > 10 && a < 27)
				.map(a -> a * 10).sum();
	}

	public static void main(String[] args) {
		// create a random data set
		final int[] data = new int[1000];
		final Random random = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(100);
		}

		// submit the task to the pool
		final ForkJoinPool pool = PoolUtil.forkJoinPool;
		final CustomRecursiveTask finder = new CustomRecursiveTask(data);
		System.out.println(pool.invoke(finder));
	}
}
