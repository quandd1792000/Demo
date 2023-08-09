package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Provider;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private String[] listRandomFinal;
    private String[] listRandomFinalnotSort;
    @GetMapping("/list")
    public String homepage(Model model) {
        List<String> listRandom = new ArrayList<>();
        Random number = new Random();
        listRandomFinal = new String[1000];
        listRandomFinalnotSort = new String[1000];
        for(int i = 0; i <1000;i++){
            int randomNumber = number.nextInt(5)+1;
            String randomString = RandomStringUtils.randomAlphabetic(randomNumber)+" ";
            listRandom.add(randomString);
            listRandomFinal[i] = randomString ;
            listRandomFinalnotSort[i] = randomString ;
        }

        model.addAttribute("listRandom", listRandom);
        return "index";
    }

    @PostMapping("/sortByArrays")
    public String sortByArrays(Model model) {
        Arrays.sort(listRandomFinal);
        model.addAttribute("listRandomFinal", listRandomFinal);
        model.addAttribute("listRandom", listRandomFinalnotSort);

        return "index";
    }

    @PostMapping("/bubbleSort")
    public String bubbleSort(Model model) {
        for (int i = 0; i < 1000 - 1; i++)
            for (int j = 0; j < 1000 - i - 1; j++)
                if (listRandomFinal[j].compareTo(listRandomFinal[j + 1]) >0) {
                    String temp = listRandomFinal[j];
                    listRandomFinal[j] = listRandomFinal[j + 1];
                    listRandomFinal[j + 1] = temp;
                }
        model.addAttribute("listRandomFinal", listRandomFinal);
        model.addAttribute("listRandom", listRandomFinalnotSort);

        return "index";
    }
    @PostMapping ("/selectionSort")
    public String selectionSort(Model model) {
        for (int i = 0; i < 1000 - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < 1000; j++)
                if (listRandomFinal[j].compareTo(listRandomFinal[min_idx])<0)
                    min_idx = j;

            String temp = listRandomFinal[min_idx];
            listRandomFinal[min_idx] = listRandomFinal[i];
            listRandomFinal[i] = temp;
        }
        model.addAttribute("listRandomFinal", listRandomFinal);
        model.addAttribute("listRandom", listRandomFinalnotSort);

        return "index";
    }
    @PostMapping("/mergeSort")
    public String mergeSort(Model model) {
        service service = new service();
        service.sort(listRandomFinal,0,999);
        model.addAttribute("listRandomFinal", listRandomFinal);
        model.addAttribute("listRandom", listRandomFinalnotSort);

        return "index";
    }
    @PostMapping("/sortByStream")
    public String sortByStream(Model model) {
        List<String> listSort = List.of(listRandomFinal);
        List<String> sortedList = listSort.stream().sorted().collect(Collectors.toList());
        model.addAttribute("listRandomFinal", sortedList);
        model.addAttribute("listRandom", listRandomFinalnotSort);
        return "index";
    }


}
