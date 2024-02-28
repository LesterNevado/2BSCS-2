import java.util.*;
import java.io.*;
public class BlockSectionDA {
    private List<BlockSection> blockSectionList;

    //getter
    public List<BlockSection> getBlockSectionList(){
        return blockSectionList;
    }
    //constructor
    public BlockSectionDA() throws FileNotFoundException{
        Scanner input = new Scanner(new FileReader("BlockFile.csv"));
        blockSectionList = new ArrayList<>();

        while(input.hasNext()){
            BlockSection blockSection = new BlockSection();

            String blockSectionRow = input.nextLine();
            String[] blockSectionArray = new String[2];
            blockSectionArray = blockSectionRow.split(",");
            blockSection.setBlockCode(blockSectionArray[0].trim());
            blockSection.setAdviser(blockSectionArray[1].trim());

            StudentDA studentDA = new StudentDA(blockSection.getBlockCode());
            blockSection.setStudentList(studentDA.getStudentList());
            blockSectionList.add(blockSection);
            
        }
        
        input.close();
    }
}
