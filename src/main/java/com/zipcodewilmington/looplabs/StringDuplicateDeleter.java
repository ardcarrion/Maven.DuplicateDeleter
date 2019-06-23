package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        int[] occurrences = occurrenceArray();
        int removeCount = 0;
        String[] temp = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (occurrences[i] < maxNumberOfDuplications) {
                temp[i] = array[i];
            } else {
                temp[i] = null;
                removeCount++;
            }
        }
        return copyArrayMinusNullValues(temp, new String[array.length-removeCount]);
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int[] occurrences = occurrenceArray();
        int removeCount = 0;
        String[] temp = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (occurrences[i] != exactNumberOfDuplications) {
                temp[i] = array[i];
            } else {
                temp[i] = null;
                removeCount++;
            }
        }
        return copyArrayMinusNullValues(temp, new String[array.length-removeCount]);
    }

    private String[] copyArrayMinusNullValues(String[] temp, String[] result) {
        int resultIndex = 0;
        for (int j = 0; j < temp.length; j++) {
            if (temp[j] != null) {
                result[resultIndex] = temp[j];
                resultIndex++;
            }
        }
        return result;
    }

    private int[] occurrenceArray() {
        int[] occurrences = new int[array.length];
        int index = 0;
        for (String str : this.array) {
            occurrences[index] = numberOfOccurrences(str);
            index++;
        }
        return occurrences;
    }

    private int numberOfOccurrences(String string) {
        int count = 0;
        for (String str : this.array) if (str.equals(string)) count++;
        return count;
    }
}
