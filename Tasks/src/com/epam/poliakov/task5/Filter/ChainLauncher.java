package com.epam.poliakov.task5.Filter;

import com.epam.poliakov.task5.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChainLauncher {

    public void execute() {

        Filter filter = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory ");
        String directory = scanner.nextLine();

        if (!new File(directory).isDirectory()) {
            System.err.println("wrong directory");
            System.exit(0);
        }

        FilterHandler filterHandler = new FilterHandler(new File(directory));

        System.out.println("Filter by name (1 / 0) ");
        String name = scanner.nextLine();
        if (name.equals("1")) {
            filter = filterHandler.filterByName(filter, scanner);
        }
        System.out.println("Filter by type (1 / 0) ");
        String type = scanner.nextLine();
        if (type.equals("1")) {
            filter = filterHandler.filterByType(filter, scanner);
        }
        System.out.println("Filter by size (1 / 0) ");
        String size = scanner.nextLine();
        if (size.equals("1")) {
            filter = filterHandler.filterBySize(filter, scanner);
        }
        System.out.println("Filter by date (1 / 0) ");
        String date = scanner.nextLine();
        if (date.equals("1")) {
            filter = filterHandler.filterByDate(filter, scanner);
        }

        List<File> list = fileFilter(filter, new File(directory));

        readFile(list, scanner);
    }

    public List<File> fileList(File fileDirectory) {
        List<File> list = new ArrayList<>();

        for (File file : fileDirectory.listFiles()) {
            if (file.isDirectory()) {
                list.addAll(fileList(file));
            } else {
                list.add(file);
            }
        }
        return list;
    }

    private List<File> fileFilter(Filter filter, File directory) {
        List<File> list = new ArrayList<>();

        for (File file : fileList(directory)) {
            if (filter.acceptFile(file)) {
                list.add(file);
            }
        }
        return list;
    }

    private void readFile(List<File> list, Scanner scanner) {
        int id = 0;

        for (File f : list) {
            System.out.printf("[%d] %s \n", id++, f);
        }
        if (!list.isEmpty()) {
            System.out.println("Enter id of file to display ");
            int i = scanner.nextInt();

            for (String s : new FileReader(list.get(i))) {
                System.out.println(s);
            }
        } else {
            System.out.println("files not found...");
        }
    }
}
