
import java.util.Comparator;
import java.util.TreeSet;

public class LastNameComparator implements Comparator<Contact>{
    
    private TreeSet<Contact> tree_s = new TreeSet<>((Contact o1, Contact o2) -> 
            o1.getLastName().compareTo(o2.getLastName()));
    
    public LastNameComparator(TreeSet<Contact> tree){
        this.tree_s.addAll(tree);
    }
    
    public LastNameComparator(){
        
    }
    
    public TreeSet<Contact> SortTreeSet(){
        return tree_s;
    }
    
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
    
    
}
