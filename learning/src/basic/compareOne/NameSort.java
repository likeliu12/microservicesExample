package basic.compareOne;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NameSort {
    public static void main(String[] args) {
        Name nameArray[] = {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")
        };

        Arrays.sort(nameArray);
                
        List<Name> names = Arrays.asList(nameArray);
        
        System.out.println(names);
        
        //List l = new ArrayList();
        //l.toArray();
        
        Collections.sort(names);
        System.out.println(names);
    }
}
