package org.example.javatest2.domain;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class ArrClass {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String unSortArr;
    private String sortArr;


    public Integer getId() {
        return id;
    }

    public String getUnSortArr() {
        return unSortArr;
    }

    public void setUnSortArr(String unSortArr) {
        this.unSortArr = unSortArr;
    }

    public String getSortArr() {
        return sortArr;
    }

    public void setSortArr(String sortArr) {
        this.sortArr = sortArr;
    }

    public ArrClass(String unSortArr) {
        this.unSortArr = unSortArr;
    }
    public ArrClass(){
    }

    public ArrClass(int N){
        unSortArr = "";
        sortArr = "";
        Integer[] arr = new Integer[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        for (int i = 0; i < arr.length; i++){
            unSortArr += arr[i].toString();
            if (i != arr.length - 1){
                unSortArr += " ";
            }
        }

    }

    public void sortArr(){
        int[] array = Arrays.stream(unSortArr.split(" ")).mapToInt(Integer::parseInt).toArray();
        int buff;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    buff = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buff;
                }
            }
        }
        for (int i = 0; i < array.length; i++){
            sortArr += Integer.toString(array[i]);
            if (i != array.length - 1){
                unSortArr += " ";
            }
        }

    }
}
