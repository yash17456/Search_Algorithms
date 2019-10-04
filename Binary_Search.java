import java.util.*;
class Binary_Search
{
	public static void main(String...args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of elements in array:");
		int N=scan.nextInt();
		int high;
		int low;
		int med;
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
		{
			System.out.println("enter the element");
			arr[i]=scan.nextInt();
		}
		Arrays.sort(arr);
		System.out.println("Enter the number to be searched:");
		int k=scan.nextInt();
		high=N-1;
		low=0;
		med=(high+low)/2;
		System.out.println("The position of low is:"+low+"  The position of high is:"+high+"  The position of median is:"+med);
		while(k!=arr[med])
		{
			if(k>arr[med])
			{
				low=med;
				med=(high+low)/2;
			}
			
			else if(k<arr[med])
			{
				high=med;
				med=(high+low)/2;
			}
			System.out.println("The position of low is:"+low+"  The position of high is:"+high+"  The position of median is:"+med);
		}
		
	}
}