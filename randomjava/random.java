public class random {
    public static void main(String[] args) {
        //this program generates your gpa based on your scores in 4 subjects.
        //let's edit it so it takes user input for scores instead of hardcoding them.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter your score for subject 1:");
        double score1 = scanner.nextDouble();
        System.out.println("Enter your score for subject 2:");
        double score2 = scanner.nextDouble();
        System.out.println("Enter your score for subject 3:");
        double score3 = scanner.nextDouble();
        System.out.println("Enter your score for subject 4:");
        double score4 = scanner.nextDouble();
        
        //calculate gpa
        double gpa = (score1 + score2 + score3 + score4) / 4;
        System.out.println("Your GPA is: " + gpa);

        //now let's determine what grade you get based on your gpa, from A+ to F.
        if (gpa >= 90) {
            System.out.println("you received an A+.");
        } else if (gpa >= 80) {
            System.out.println("you received an A.");
        } else if (gpa >= 70) {
            System.out.println("you received a B.");
        } else if (gpa >= 60) {
            System.out.println("you received a C.");
        } else if (gpa >= 50) {
            System.out.println("you received a D.");
        } else {
            System.out.println("you received an F.");
        }
        
        //now let's add a switch statement to give feedback based on the grade.
        int gradeCategory = (int) (gpa / 10);
        switch (gradeCategory) {
            case 10:
            case 9:
                System.out.println("nice, you did okay.");
                break;
            case 8:
                System.out.println("you can do better.");
                break;
            case 7:
                System.out.println("ooh ... uhm ... i would say you need to study more.");
                break;
            case 6:
                System.out.println("i would be bawling if i were you.");
                break;
            case 5:
                System.out.println("my mother would've KILLED me, if i got anything under an 85.");
                break;
            default:
                System.out.println("... you're fucked. uhh ... yeah, forget about ANY uni.");
                break;
        }
        //wait now let's add a thing that measures whether u'd get into university of toronto based on ur gpa.
        if (gpa >= 85) {
            System.out.println("you meet minimum requirements for uoft, dk what else to say.");
        } else {
            System.out.println("have fun not going to uoft. dumbass.");
        }

     //now to calculate scholarship eligibility based on gpa.
        if (gpa >= 90) {
        System.out.println("you can get a full scholarship ... nice.");
    } else if (gpa >= 80) {
        System.out.println("hmmm .... kinda dumb you are, but ok.");
    } else {
        System.out.println("DUMBASSSS DETECTED, no you can't get a scholarship.");
    }
    
    //end of code.
        scanner.close();
    }
}
