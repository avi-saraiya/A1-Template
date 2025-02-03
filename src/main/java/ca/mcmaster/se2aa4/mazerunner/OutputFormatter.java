package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class OutputFormatter{
    public StringBuilder solFormat(List<String> stringList){
        String container = stringList.get(0);
        StringBuilder outputstr = new StringBuilder();
        for (String element: stringList){
            if (!(element.equals(container))){
                outputstr.append(" ");
                container = element;
            }
            outputstr.append(element);
            }
        return outputstr;
    }
}