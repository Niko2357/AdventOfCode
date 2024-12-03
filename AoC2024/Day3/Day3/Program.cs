using System.Data;
using System.Text.RegularExpressions;

namespace Day3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string text = " ";

            try
            {
                using(StreamReader reader = new StreamReader("D:\\Nikolka_skola\\Programování\\C#\\AoC2024\\Day3\\Day3\\input.txt"))
                {
                    text = reader.ReadToEnd();
                }
            }catch(Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }

            Console.WriteLine(Sum(Multiplicate(Exctract(text))));

            Console.WriteLine(ExtractSecond(text));
        }

        public static List<string> Exctract(string text)
        {
            List<string> mul = new List<string>();
            string pattern = @"mul\(\d+\,\d+\)";
            MatchCollection match = Regex.Matches(text, pattern);
            foreach(Match m in match)
            {
                mul.Add(m.Value);
            }
            return mul;
        }

        public static List<int> Multiplicate(List<string> mul)
        {
            List<int> sumIt = new List<int>();
            string pattern = @"\d+";
            foreach(string m in mul)
            {
                MatchCollection match = Regex.Matches(m, pattern);
                match.ToArray();
                int a = int.Parse(match[0].Value);
                int b = int.Parse(match[1].Value);
                sumIt.Add(a*b);
            }
            return sumIt;
        }

        public static int Sum(List<int> sumIt)
        {
            int sum = 0;
            foreach(int i in sumIt)
            {
                sum += i;
            }
            return sum;
        }

        public static int ExtractSecond(string text)
        {
            int sum = 0;
            bool isEnabled = true;
            string pattern = @"(do\(\)|don't\(\))|mul\((\d+),(\d+)\)";
            Regex r = new Regex(pattern);

            MatchCollection matches = r.Matches(text);
            foreach (Match m in matches)
            {
                if (m.Groups[1].Success) 
                {
                    string instruction = m.Groups[1].Value;
                    isEnabled = instruction == "do()";
                }
                else if (m.Groups[2].Success && m.Groups[3].Success && isEnabled) 
                {
                    int a = int.Parse(m.Groups[2].Value); 
                    int b = int.Parse(m.Groups[3].Value);
                    sum += a * b; 
                }
            }
            return sum;
        }
    }
}
