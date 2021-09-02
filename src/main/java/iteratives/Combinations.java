package iteratives;

import java.util.Arrays;

public class Combinations {


    private int[] Indices;

    // Number of elements in the combination
    private int R;

    // The boolean array
    private boolean[] Flags;

    // Starting index of the 1st tract of trues
    private int Start;

    // Ending index of the 1st tract of trues
    private int End;

    // Constructor
    public Combinations(int[] arr, int r)
    {
        this.Indices = arr;
        this.R = r;
    }

    // Set the 1st r Booleans to true,
    // initialize Start and End
    public void GetFirst()
    {
        Flags = new boolean[this.Indices.length];

        // Generate the very first combination
        for (int i = 0; i < this.R; ++i)
        {
            Flags[i] = true;
        }

        // Update the starting ending indices
        // of trues in the boolean array
        this.Start = 0;
        this.End = this.R - 1;
        this.Output();
    }

    // Function that returns true if another
    // combination can still be generated
    public boolean HasNext()
    {
        return End < (this.Indices.length - 1);
    }

    // Function to generate the next combination
    public void Next()
    {

        // Only one true in the tract
        //it is the last condition
        if (this.Start == this.End)
        {
           // System.out.printf("start %s , end %s",this.Start,this.End);
            this.Flags[this.End] = false;
            this.Flags[this.End + 1] = true;
            this.Start += 1;
            this.End += 1;
            while (this.End + 1 < this.Indices.length
                    && this.Flags[this.End + 1])
            {
                ++this.End;
            }
        }
        else
        {

            // Move the End and reset the End
            if (this.Start == 0)
            {
                Flags[this.End] = false;
                Flags[this.End + 1] = true;
                this.End -= 1;
            }
            else
            {
                Flags[this.End + 1] = true;

                // Set all the values to false starting from
                // index Start and ending at index End
                // in the boolean array
                for (int i = this.Start; i <= this.End; ++i)
                {
                    Flags[i] = false;
                }

                // Set the beginning elements to true
                for (int i = 0; i < this.End - this.Start; ++i)
                {
                    Flags[i] = true;
                }

                // Reset the End
                this.End = this.End - this.Start - 1;
                this.Start = 0;
            }
        }
        this.Output();
    }

    // Function to print the combination generated previouslt
    private void Output()
    {
        System.out.println(Arrays.toString(Flags));
        System.out.printf("start %s , end %s \n",this.Start,this.End);

        for (int i = 0, count = 0; i < Indices.length
                && count < this.R; ++i)
        {

            // If current index is set to true in the boolean array
            // then element at current index in the original array
            // is part of the combination generated previously
            if (Flags[i])
            {
                System.out.print(Indices[i]);
                System.out.print(" ");
                ++count;
            }
        }
        System.out.println();
    }
}

class GFG
{
    public static void main(String[] args)
    {
        int[] arr = { 0, 1, 2, 3 ,4};
        int r = 3;
        Combinations com = new Combinations(arr, r);
        com.GetFirst();
        while (com.HasNext())
        {
            com.Next();
        }
    }
}
