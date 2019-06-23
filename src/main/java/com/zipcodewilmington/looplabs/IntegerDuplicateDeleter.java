package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        int[] occurrences = occurrenceArray();
        int removeCount = 0;
        Integer[] temp = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            if (occurrences[i] < maxNumberOfDuplications) {
                temp[i] = array[i];
            } else {
                temp[i] = null;
                removeCount++;
            }
        }
        return copyArrayMinusNullValues(temp, new Integer[array.length-removeCount]);
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int[] occurrences = occurrenceArray();
        int removeCount = 0;
        Integer[] temp = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            if (occurrences[i] != exactNumberOfDuplications) {
                temp[i] = array[i];
            } else {
                temp[i] = null;
                removeCount++;
            }
        }
        return copyArrayMinusNullValues(temp, new Integer[array.length-removeCount]);
    }

    private Integer[] copyArrayMinusNullValues(Integer[] temp, Integer[] result) {
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
        for (Integer i : this.array) {
            occurrences[index] = numberOfOccurrences(i);
            index++;
        }
        return occurrences;
    }
    private int numberOfOccurrences(Integer number) {
        int count = 0;
        for (Integer i : this.array) if (i.equals(number)) count++;
        return count;
    }
}

