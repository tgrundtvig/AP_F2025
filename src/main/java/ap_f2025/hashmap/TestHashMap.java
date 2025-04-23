package ap_f2025.hashmap;

public class TestHashMap
{
    public static void main(String[] args)
    {
        int n = 40000000;
        Person[] persons = new Person[n];
        for(int i = 0; i < n; i++)
        {
            persons[i] = new Person("FN"+i, "LN" + i, (int) Math.random()*100);
        }
        System.out.println("Created " + n + " persons");
        HashMap<String, Person> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            map.put(persons[i].getFirstName(), persons[i]);
        }
        System.out.println("Inserted " + n + " persons into the map");
        int longestChain = map.getLongestChain();
        System.out.println("Longest chain: " + longestChain);
    }
}
