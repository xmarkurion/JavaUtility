package markurion.strings.randomizer;

import markurion.strings.clipboard.MClipboard;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.util.List;

public class Randomizer {

    //variable that will hold our data stream
    private String data;
    private List<String> tempList;

    Randomizer(String data){
        this.data = data;
        this.tempList = Arrays.asList(data.split("\\s*,\\s*"));
        removeDuplicates();
    }

    public List<String> getTempList() {
        return tempList;
    }

    @Override
    public String toString() {
        return listToString(this.tempList);
    }

    public void removeDuplicates(){
        this.tempList = new ArrayList<>(new HashSet<>(tempList));
    }

    private String listToString(List<String> a){
        String preFinalOutput = "" + a;
        return preFinalOutput.substring(1,preFinalOutput.length()-1);
    }

    public void shuffleData(){
        Collections.shuffle(this.tempList);

        MClipboard clipboard = new MClipboard();
        clipboard.addToClipboard(listToString(this.tempList));
    }

    public void addToClipboard(String text){
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    public static void main(String[] args){
        Randomizer simple = new Randomizer("2.298, 2.283, 2.281, 2.397, 2.396, 2.270, 2.384, 2.262, 2.255, 2.246, 2.299, 2.292, 2.285, 2.282, 2.275, 2.386, 2.383, 2.379, 2.376, 2.248, 2.276, 2.263, 2.241, 2.481, 2.237, 2.353, 2.351, 2.346, 2.211, 2.321, 2.300, 2.272, 2.249, 2.364, 2.363, 2.362, 2.476, 2.228, 2.338, 2.330, 2.209, 2.253, 2.422, 2.421, 2.420, 2.469, 2.306, 2.403, 2.406, 2.442, 2.274, 2.271, 2.267, 2.258, 2.252, 2.229, 2.347, 2.345, 2.340, 2.367, 2.332, 2.373, 2.393, 2.382, 2.375, 2.398, 2.284, 2.269, 2.251, 2.268, 2.291, 2.287, 2.483, 2.450, 2.474, 2.377, 2.309, 2.254, 2.293,");
        System.out.println("Before:   " + simple.getTempList().size());
        simple.shuffleData();
        System.out.println("After: "+ simple.getTempList().size());
    }
}
