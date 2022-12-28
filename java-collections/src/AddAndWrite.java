
import java.io.*;
import java.util.*;
public class AddAndWrite{
    HashMap<String,String> fileKeys;
    private final String defaultFileName;
    public AddAndWrite(HashMap<String, String> fileKeys,String defaultFileName) {
        this.fileKeys = fileKeys;
        this.defaultFileName = defaultFileName;
    }
    
    public <T extends Collection<Contact>> T getCollections(T list) 
            throws IOException{
        
        File file = new File("..\\"+defaultFileName);
        try (BufferedReader b_reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = b_reader.readLine())!=null){
                String[] lines = line.split(" ");
                Contact cont = new Contact(lines[0], lines[1], lines[2], lines[3]);
                list.add(cont);
            }
        }
        return list;
    }
    
    public <T extends Collection<Contact>> void WriteTxt(T list,String fileKey)
            throws IOException{
        
        String fileName = fileKeys.get(fileKey);
        File file = new File("..\\dosyalar\\"
                + fileName);
        
        try (FileWriter fileWrite = new FileWriter(file)) {
            Iterator<Contact> iterat=list.iterator();
            
            while(iterat.hasNext()){
                String line = iterat.next().toString();
                fileWrite.write(line);
            }
        }
        System.out.println(fileName+" olarak yazildi.");
    }
    
    public void addHashMap(HashMap<String,Contact> hasMap) throws IOException{
        File file = new File("..\\"+defaultFileName);
        try (BufferedReader b_reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = b_reader.readLine())!=null){
                String[] lines = line.split(" ");
                Contact cont = new Contact(lines[0], lines[1], lines[2], lines[3]);
                hasMap.put(cont.getPhoneNumber(), cont);
            }
        }
    }
    
    public void WriteTxt(HashMap<String,Contact> hashMap,String fileKey) 
            throws IOException{
        String fileName = fileKeys.get(fileKey);
        File file = new File("..\\dosyalar\\"
                + fileName);
        
        try (FileWriter fileWrite = new FileWriter(file)) {
            Set entrySet = hashMap.entrySet();
            Iterator iterat = entrySet.iterator();
            while(iterat.hasNext()){
                Map.Entry me = (Map.Entry)iterat.next();
                String line = me.getKey().toString();
                fileWrite.write(hashMap.get(line).toString());
            }
        }
        System.out.println(fileName+" olarak yazildi.");
    }

}
