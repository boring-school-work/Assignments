public class Person {
    private String name;
    private int age;
    private static int votingAge;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static public void setVotingAge(int voteAge) {
       votingAge = voteAge;
    }

    static public int getVotingAge() {
       return votingAge;
    }

    public void display() {
        System.out.println("The voting age is " + getVotingAge());
    }
}
