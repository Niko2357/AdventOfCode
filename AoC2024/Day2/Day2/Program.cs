using System.Diagnostics;

namespace Day2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<string> line = new List<string>();
            try
            {
                using (StreamReader reader = new StreamReader("D:\\Nikolka_skola\\Programování\\C#\\AoC2024\\Day2\\Day2\\input.txt"))
                {
                    string s = "";
                    while ((s = reader.ReadLine()) != null)
                    {
                        line.Add(s);
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }

            Console.WriteLine(Safe(Parsing(line)));
        }
        public static List<List<int>> Parsing(List<string> line)
        {
            List<List<int>> levels = new List<List<int>>();
            List<int> inLevels = new List<int>();
            foreach (string s in line)
            {
                string[] nums = s.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                for(int i = 0; i < nums.Length; i++)
                {
                    inLevels.Add(int.Parse(nums[i]));
                }
                levels.Add(inLevels);
            }
            return levels;
        }

        public static int Safe(List<List<int>> levels)
        {
            int count = 0;
            foreach(List<int> level in levels)
            {
                for(int i = 1; i < level.Count; i++)
                { 
                    int difference = level[i] - level[i - 1];
                    if (Math.Abs(difference) < 4 && Math.Abs(difference) > 0)
                    {
                        count++;
                    }
                    if(difference < 0 || difference > 0)
                    {
                        count--;
                    } 
                }
            }
            return count;
        }
    }
}
