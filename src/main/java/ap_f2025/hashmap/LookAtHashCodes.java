package ap_f2025.hashmap;

public class LookAtHashCodes
{
    public static void main(String[] args)
    {
        Person tobias = new Person("Tobias", "Grundtvig", 51);
        Person maria = new Person("Maria", "Hansen", 50);
        Person tobias2 = new Person("Tobias", "Grundtvig", 51);
        System.out.println("tobias: " + tobias + " hashCode: " + tobias.hashCode());
        System.out.println("maria: " + maria + " hashCode: " + maria.hashCode());
        System.out.println("tobias2: " + tobias2 + " hashCode: " + tobias2.hashCode());
        System.out.println("tobias == tobias2: " + (tobias == tobias2));
        tobias2.setFirstName("Morten");
        System.out.println("tobias: " + tobias + " hashCode: " + tobias.hashCode());
        System.out.println("maria: " + maria + " hashCode: " + maria.hashCode());
        System.out.println("tobias2: " + tobias2 + " hashCode: " + tobias2.hashCode());

    }
}
