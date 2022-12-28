
import java.io.IOException;
import java.util.*;

public class Manager {
    private HashMap<String,String> fileKeys = new HashMap<>();;
    private AddAndWrite add_write;
    private HashSet<Contact> hashSet;
    private TreeSet<Contact> treeSet;
    private List<Contact> list;
    private HashMap<String,Contact> hashMap;
    
    public Manager(String contactFileName){
        add_write = new AddAndWrite(fileKeys,contactFileName);
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        list = new ArrayList<>();
        hashMap = new HashMap<>();
        addFileKey(fileKeys);
    }
    
    public void StartWrite() throws IOException{
        list_w();
        sortList_w();
        hashSet_w();
        treeSet_w();
        sortTreeSet_w();
        hashMap_w();
    }
    
    private void hashMap_w() throws IOException{
        add_write.addHashMap(hashMap);
        add_write.WriteTxt(hashMap, "hashMap");
    }
    
    private void hashSet_w() throws IOException{
        add_write.getCollections(hashSet);
        add_write.WriteTxt( hashSet,"hashSet");
    }
    
    private void treeSet_w() throws IOException{
        add_write.getCollections(treeSet);
        add_write.WriteTxt(treeSet,"treeSet");
    }
    
    private void sortTreeSet_w() throws IOException{
        treeSet = new LastNameComparator(treeSet).SortTreeSet();
        add_write.WriteTxt(treeSet, "sortTreeSet");
    }
    
    private void list_w() throws IOException{
        add_write.getCollections(list);
        add_write.WriteTxt( list, "list");
    }
    
    private void sortList_w() throws IOException{
        Collections.sort(list,new LastNameComparator());
        add_write.WriteTxt(list,"sortList");
    }
    
    private void addFileKey(HashMap<String,String> fileKeys){
        fileKeys.put("list", "contactArrayList.txt");
        fileKeys.put("sortList", "contactsArrayListOrderByLastName.txt");
        fileKeys.put("hashSet", "contactHashSet.txt");
        fileKeys.put("treeSet", "contactTreeSet.txt");
        fileKeys.put("sortTreeSet", "contactTreeSetOrderByLastName.txt");
        fileKeys.put("hashMap", "file.txt");
    }
}
