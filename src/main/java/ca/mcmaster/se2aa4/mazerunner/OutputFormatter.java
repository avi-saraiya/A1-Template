package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class OutputFormatter{
    // Formats the path through the maze according to the business logic (canonical form)
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
        System.out.print("Canonical Form: ");
        System.out.println(outputstr);
        return outputstr;
    }

    // Formats the path through the maze according to the business logic (factorized form)
    public StringBuilder factorize(StringBuilder input){
        String proxystr = input.toString();
        String[] splitstr = proxystr.split("\\s+");// Checks for space (regex)
        StringBuilder output = new StringBuilder();
        for (String element : splitstr){
            StringBuilder temp = new StringBuilder();
            temp.append(element.charAt(0));
            String len = String.valueOf(element.length());
            if (!(len.equals("1"))){
                temp.insert(0, len);
            }
            temp.append(" ");
            output.append(temp);
        }
        System.out.print("Factorized Form: ");
        System.out.println(output);
        return output;
    }
}