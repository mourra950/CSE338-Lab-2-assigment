public class maxandmin {
    public static int[] checkeq(int number[])
    {
        if (number.length<1)
            throw new IllegalArgumentException("we need numbers to proccess");

        int max=number[0];
        int min=number[0];
        for (int i=1;i<number.length;i++)
            if(number[i]>max)
                max=number[i];
            else if(number[i]<min)
                min=number[i];
        int[] answer={min,max};
        return answer;
    }
}
