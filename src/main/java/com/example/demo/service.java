package com.example.demo;

public class service {
    public void merge(String[] listString, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        String[] L = new String[n1];
        String[] R= new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = listString[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = listString[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) < 0 || L[i].compareTo(R[j]) == 0 ) {
                listString[k] = L[i];
                i++;
            } else {
                listString[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            listString[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            listString[k] = R[j];
            j++;
            k++;
        }
    }

    public void sort(String arr[], int l, int r) {
        if (l < r) {

            // Tìm điểm chính giữa
            int m = (l + r) / 2;

            // Hàm đệ quy tiếp tục chia đôi
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}
