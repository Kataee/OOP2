package dictionary;

import dictionary.interfaces.IDictionary;

import java.util.ArrayList;

public class ArrayListDictionary implements IDictionary {
    private ArrayList<String> words = new ArrayList<>();
    private static ArrayListDictionary instance = null;


}
