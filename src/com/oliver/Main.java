package com.oliver;

public class Main {

    public static void main(String[] args) {

        FileIOReader file1 = new FileIOReader("/Users/Christopher/IdeaProjects/Merge-Sorted-Files/file1.txt");
        FileIOReader file2 = new FileIOReader("/Users/Christopher/IdeaProjects/Merge-Sorted-Files/file2.txt");
        FileIOReader file3 = new FileIOReader("/Users/Christopher/IdeaProjects/Merge-Sorted-Files/file3.txt");
        FileIOReader file4 = new FileIOReader("/Users/Christopher/IdeaProjects/Merge-Sorted-Files/file4.txt");
        FileIOReader file5 = new FileIOReader("/Users/Christopher/IdeaProjects/Merge-Sorted-Files/file5.txt");
        FileIOWriter output = new FileIOWriter("/Users/Christopher/IdeaProjects/Merge-Sorted-Files/output.txt");

        MinimumBinaryHeap heap = new MinimumBinaryHeap(5);

        String file1Line = file1.readLine();
        loadHeap(heap, 1, file1Line);
        String file2Line = file2.readLine();
        loadHeap(heap, 2, file2Line);
        String file3Line = file3.readLine();
        loadHeap(heap, 3, file3Line);
        String file4Line = file4.readLine();
        loadHeap(heap, 4, file4Line);
        String file5Line = file5.readLine();
        loadHeap(heap, 5, file5Line);

        while(heap.getNumEntries() > 0) {
            switch(heap.deletemin()) {
                case 1:
                    output.writeLine(file1Line);
                    file1Line = file1.readLine();
                    if(file1Line != null) loadHeap(heap, 1, file1Line);
                    break;
                case 2:
                    output.writeLine(file2Line);
                    file2Line = file2.readLine();
                    if(file2Line != null) loadHeap(heap, 2, file2Line);
                    break;
                case 3:
                    output.writeLine(file3Line);
                    file3Line = file3.readLine();
                    if(file3Line != null) loadHeap(heap, 3, file3Line);
                    break;
                case 4:
                    output.writeLine(file4Line);
                    file4Line = file4.readLine();
                    if(file4Line != null) loadHeap(heap, 4, file4Line);
                    break;
                case 5:
                    output.writeLine(file5Line);
                    file5Line = file5.readLine();
                    if(file5Line != null) loadHeap(heap, 5, file5Line);
                    break;
            }
        }

        file1.close();
        file2.close();
        file3.close();
        file4.close();
        file5.close();
        output.close();
    }

    public static void loadHeap(MinimumBinaryHeap h, int file, String line) {

        if(line == null) return;

        String splitIt[] = line.split(",");
        h.insert(Integer.parseInt(splitIt[0]), file);
    }
}
