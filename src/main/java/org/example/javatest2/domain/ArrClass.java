package org.example.javatest2.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class ArrClass {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String unSortArr;
    private String sortArr;

    @Transient
    private int N;
    @Transient
    ArrayList<Integer> arrlist;


    public Integer getId() {
        return id;
    }
    public Integer getN() {
        return N;
    }
    public String getUnSortArr() { return unSortArr; }
    public String getSortArr() {
        return sortArr;
    }
    public ArrayList<Integer> getArrlist() { return arrlist; }
    public void setN(int N){this.N = N;}
    public void setUnSortArr(String unSortArr) {
        this.unSortArr = unSortArr;
    }
    public void setSortArr(String sortArr) {
        this.sortArr = sortArr;
    }
    public void setArrlist(ArrayList<Integer> arrlist) { this.arrlist = arrlist; }

    public ArrClass(){}

    public ArrClass(int N){
        unSortArr = "";
        sortArr = "";
        this.N = N;
        arrlist = new ArrayList<>();

    }
    public void genArr(){
        for (int i = 0; i < N; i++){
            arrlist.add((int) (Math.random() * 10));
        }
        unSortArr = arrlist.toString();
        unSortArr = unSortArr.substring(1, unSortArr.length() -1).replaceAll(",","");
    }

    public void sortArr() {
        int buff;
        for (int i = 0; i < arrlist.size(); i++) {
            for (int j = 0; j < arrlist.size() - 1; j++) {
                if (arrlist.get(j) < arrlist.get(j + 1)) {
                    buff = arrlist.get(j);
                    arrlist.set(j, arrlist.get(j + 1));
                    arrlist.set(j + 1, buff);
                }
            }
        }
        sortArr = arrlist.toString();
        sortArr = sortArr.substring(1, sortArr.length() - 1).replaceAll(",", "");

    }
        public void strTolist (String str){
            String[] arrStr = str.split(" ");
            arrlist.clear();
            for (String s : arrStr) {
                arrlist.add(Integer.parseInt(s));
            }
        }
}


