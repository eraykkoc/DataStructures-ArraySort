import java.util.Random;

class ArraySort
{
    private static long[] a;
    private static int nElems;
    private int comp = 0;
    private int copy = 0;
    private int copyEven = 0;
    private int copyOdd = 0;
    private int N = 25;

    public ArraySort(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value)
    {
        a[nElems] = value;
        nElems++;
    }

    public void display()
    {
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void setnElems(int x)
    {
        nElems = x;
    }

    public void clear(){
        copy = 0;
        comp = 0;
    }

    public int[] bubbleSort()
    {
        int[] C = new int[2];
        int out, in;
        int i,j,d=0;

        for (out = nElems - 1; out >= 1; out--)
            for (in = 0; in < out; in++)

                if (a[in] > a[in + 1])
                {
                    long temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                    copy +=3;
                }

        C[0] = N*(N-1)/2;
        C[1] = copy;
        return C;
    }

    public int[] selectionSort()
    {
        int[] D = new int[2];
        int out, in, min;

        for(out=0; out<nElems-1; out++)
        {
            min = out;
            for(in=out+1; in<nElems; in++)
                if(a[in] < a[min])
                    min = in;
            {
                long temp = a[out];
                a[out] = a[min];
                a[min] = temp;
                copy +=3;
            }

        }
        D[0] = N*(N-1)/2;
        D[1] = copy;
        return D;
    }

    public int[] insertionSort()
    {
        int in, out;
        int[] E = new int[2];

        for(out=1; out<nElems; out++)
        {
            long temp = a[out];
            in = out;
            while(in>0 && a[in-1] >= temp)
            {
                a[in] = a[in-1];
                --in;
                comp +=2;
                copy ++;
            }
            a[in] = temp;
            comp +=2;
            copy +=2;
        }

        E[0] = comp;
        E[1] = copy;
        return E;
    }

    public int[] oddEvenSort()
    {
        int[] B = new int[2];

        int k,m,j,i;

        for(i = 0; i < nElems-1; i++) {
            for (j = i + 1; j < nElems; j++)

                if (a[i] > a[j]) {

                    for (k = 0; k < nElems - 1; k += 2)
                        if (a[k] > a[k + 1]) {

                            long temp = a[k];
                            a[k] = a[k + 1];
                            a[k + 1] = temp;
                            copyEven+= 3;

                        }

                    for (m = 1; m < nElems - 1; m += 2)
                        if (a[m] > a[m + 1]) {

                            long temp = a[m];
                            a[m] = a[m + 1];
                            a[m + 1] = temp;
                            copyOdd+= 3;

                        }
                    i = 0;
                    j = 0;
                    comp++;

                }
        }
        B[0] = (N - 1) * comp;
        B[1] = copyEven + copyOdd;
        return B;
    }

}

class ArraySortApp
{
    public static void main(String[] args) {
        int maxSize = 100;
        int i, j;

        ArraySort arr;
        arr = new ArraySort(maxSize);

        Random r = new Random();


        //BUBBLE

        System.out.println("\nBubbleSort TEST");
        System.out.println("-----------------");

        for (i = 1; i <= 20; i++) {
            System.out.println(i + ". TEST");
            for (j = 0; j < 25; j++){
                arr.insert(r.nextInt(100));
            }
            arr.display();
            arr.bubbleSort();
            arr.display();

            System.out.println("Comparison : " + arr.bubbleSort()[0]);
            System.out.println("Copies : " + arr.bubbleSort()[1]);

            arr.setnElems(0);
            System.out.println(" ");
        }
        System.out.println("Average Comparison : " + arr.bubbleSort()[0]);
        System.out.println("Average Copies : " + (double)arr.bubbleSort()[1]/20);
        arr.clear();


        //SELECTION

        System.out.println("\nSelectionSort TEST");
        System.out.println("-----------------");

        for (i = 1; i <= 20; i++) {
            System.out.println(i + ". TEST");
            for (j = 0; j < 25; j++){
                arr.insert(r.nextInt(100));
            }
            arr.display();
            arr.selectionSort();
            arr.display();

            System.out.println("Comparison : " + arr.selectionSort()[0]);
            System.out.println("Copies : " + arr.selectionSort()[1]);

            arr.setnElems(0);
            System.out.println(" ");
        }

        System.out.println("Average Comparison : " + arr.selectionSort()[0]);
        System.out.println("Average Copies : " + (double) arr.selectionSort()[1]/20);
        arr.clear();


        // INSERTION

        System.out.println("\nInsertion TEST");
        System.out.println("-----------------");

        for (i = 1; i <= 20; i++) {
            System.out.println(i + ". TEST");
            for (j = 0; j < 25; j++){
                arr.insert(r.nextInt(100));
            }
            arr.display();
            arr.insertionSort();
            arr.display();

            System.out.println("Comparison : " + arr.insertionSort()[0]);
            System.out.println("Copies : " + arr.insertionSort()[1]);

            arr.setnElems(0);
            System.out.println(" ");
        }

        System.out.println("Average Comparison : " + (double)arr.insertionSort()[0]/20);
        System.out.println("Average Copies : " + (double)arr.insertionSort()[1]/20);
        arr.clear();


        //ODD EVEN

        System.out.println("\nOddEvenSort TEST");
        System.out.println("-----------------");

        for (i = 1; i <= 20; i++) {
            System.out.println(i + ". TEST");
            for (j = 0; j < 25; j++){
                arr.insert(r.nextInt(100));
            }
            arr.display();
            arr.oddEvenSort();
            arr.display();

            System.out.println("Comparison : " + arr.oddEvenSort()[0]);
            System.out.println("Copies : " + arr.oddEvenSort()[1]);

            arr.setnElems(0);
            System.out.println(" ");
        }
        System.out.println("Average Comparison : " + (double)arr.oddEvenSort()[0]/20);
        System.out.println("Average Copies : " + (double)arr.oddEvenSort()[1]/20);


    }
}