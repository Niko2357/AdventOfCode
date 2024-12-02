using System.Diagnostics.Contracts;

namespace Day1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<string> line = new List<string>();
       
            try
            {
                using (StreamReader reader = new StreamReader("D:\\Nikolka_skola\\Programování\\C#\\AoC2024\\Day1\\Day1\\input.txt"))
                {
                    string s = "";
                    while((s = reader.ReadLine()) != null)
                    {
                        line.Add(s);
                    }
                }
            }catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
            List<int> nums1 = new List<int>();
            List<int> nums2 = new List<int>();

            List<int> distance = new List<int>();

            IntoNums(line, nums1, nums2);

            Substraction(nums1 , nums2, distance);
            Console.WriteLine(Sum(distance));

            Console.WriteLine(Sum(FindSame(nums1, nums2)));
        }

        public static void IntoNums(List<string> line, List<int> nums1, List<int> nums2)
        {
            string[] strings = line.ToArray();
           foreach (string s in strings)
            {
                string[] part = s.Split(' ', StringSplitOptions.RemoveEmptyEntries);
                nums1.Add(int.Parse(part[0]));
                nums2.Add(int.Parse(part[1]));
            }
            nums1.Sort();
            nums2.Sort();
        }

        public static void Substraction(List<int> nums1, List<int> nums2, List<int> distance)
        {
            int[] minus = nums2.ToArray();
            int number = 0;
            int support = 0;
            foreach (int i in nums1)
            {
                number = i - minus[support];
                if(number < 0)
                {
                    number =number * -1;
                }
                distance.Add(number);
                support++;
            }
        }

        public static int Sum(List<int> distance)
        {
            int finalNumber = 0;
            foreach(int i in distance)
            {
                finalNumber += i;
            }
            return finalNumber;
        }

        public static List<int> FindSame(List<int> nums1 , List<int> nums2)
        {
            int count = 0;
            List<int> similarity = new List<int>();
            foreach(int i in nums1)
            {
                count = 0;
                foreach(int j in nums2)
                {
                    if(i == j)
                    {
                        count++;
                    }
                }
                similarity.Add(i * count);
            }
            return similarity;
        }

        public static void WriteOut(List<int> list)
        {
            foreach(int i in list)
            {
                Console.WriteLine(i);
            }
        }
    }
}
