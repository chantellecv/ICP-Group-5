public class Assignment extends Faculty implements AssignmentInterface{

    public void viewAssignmentScore(){
        if (login() == true ){
            System.out.println("Please enter an email address:");
            email = sc.nextLine();

            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            int index = assignment.indexOf(assignmentName);
            System.out.println(scores.get(index));
        }
    }

    public void viewAssignmentScores(){
        if (login() == true && isFaculty() == true) {

            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            if (courseCodes.contains(courseCode) && assignment.contains(assignmentName)) {
                System.out.println("The scores are: " + scores.get(courseCodes.indexOf(courseCode)));
            }
        }
    }

    public void viewAllAssignmentScores(){
        if (login() == true) {
            System.out.println("Please enter an email address:");
            email = sc.nextLine();

            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();

            for (int i = 0; i < submitterEmails.size(); i++) {
                if (courseCodes.contains(courseCode) && (submitterEmails.get(i)).contains(email)) {
                    System.out.println("Your scores are " + scores.get(i));
                }
            }
        }
    }

    public void viewAssignmentGrade(){
        if (login() == true) {
            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            if (submitterEmails.contains(email) && courseCodes.contains(courseCode) && assignment.contains(assignmentName)) {
                System.out.println("The score for " + assignmentName + " is " + scores.get(submitterEmails.indexOf(email)));

                if (scores.get(submitterEmails.indexOf(email)) >= 85 && scores.get(submitterEmails.indexOf(email)) <= 100) {
                    System.out.println("Grade: A+");

                } else if (scores.get(submitterEmails.indexOf(email)) >= 80 && scores.get(submitterEmails.indexOf(email)) <= 84) {
                    System.out.println("Grade: A");

                } else if (scores.get(submitterEmails.indexOf(email)) >= 75 && scores.get(submitterEmails.indexOf(email)) <= 79) {
                    System.out.println("Grade: B+");

                } else if (scores.get(submitterEmails.indexOf(email)) >= 70 && scores.get(submitterEmails.indexOf(email)) <= 74) {
                    System.out.println("Grade: B");

                } else if (scores.get(submitterEmails.indexOf(email)) >= 65 && scores.get(submitterEmails.indexOf(email)) <= 69) {
                    System.out.println("Grade: C+");

                } else if (scores.get(submitterEmails.indexOf(email)) >= 60 && scores.get(submitterEmails.indexOf(email)) <= 64) {
                    System.out.println("Grade: C");

                } else if (scores.get(submitterEmails.indexOf(email)) >= 55 && scores.get(submitterEmails.indexOf(email)) <= 59) {
                    System.out.println("Grade: D+");

                } else if (scores.get(submitterEmails.indexOf(email)) >= 50 && scores.get(submitterEmails.indexOf(email)) <= 54) {
                    System.out.println("Grade: D");
                    
                } else if (scores.get(submitterEmails.indexOf(email)) >= 0 && scores.get(submitterEmails.indexOf(email)) <= 49) {
                    System.out.println("Grade: E");
                }
            }
        }
    }

    public void viewAssignmentGrades(){
        if (login() == true && isFaculty()) {
            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            for (int i = 0; i < submitterEmails.size(); i++) {
                if (courseCodes.contains(courseCode) && (submitterEmails.get(i)).contains(email) && assignmentName.contains(assignmentName)) {
                    if (scores.get(submitterEmails.indexOf(email)) >= 85 && scores.get(submitterEmails.indexOf(email)) <= 100) {
                        System.out.println("Grade: A+" + " Score: " + scores.get(i));
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 80 && scores.get(submitterEmails.indexOf(email)) <= 84) {
                        System.out.println("Grade: A" + " Score: " + scores.get(i));
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 75 && scores.get(submitterEmails.indexOf(email)) <= 79) {
                        System.out.println("Grade: B+" + " Score: " + scores.get(i));
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 70 && scores.get(submitterEmails.indexOf(email)) <= 74) {
                        System.out.println("Grade: B" + " Score: " + scores.get(i));
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 65 && scores.get(submitterEmails.indexOf(email)) <= 69) {
                        System.out.println("Grade: C+" + " Score: " + scores.get(i));
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 60 && scores.get(submitterEmails.indexOf(email)) <= 64) {
                        System.out.println("Grade: C" + " Score: " + scores.get(i));
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 55 && scores.get(submitterEmails.indexOf(email)) <= 59) {
                        System.out.println("Grade: D+" + " Score: " + scores.get(i));
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 50 && scores.get(submitterEmails.indexOf(email)) <= 54) {
                        System.out.println("Grade: D" + " Score: " + scores.get(i));
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 0 && scores.get(submitterEmails.indexOf(email)) <= 49) {
                        System.out.println("Grade: E" + " Score: " + scores.get(i));
                    }

                }
            }
        }
    }

    public void viewAllAssignmentGrades(){
        if (login() == true) {
            System.out.println("Please enter your course code: ");
            courseCode = sc.nextLine();
            for (int i = 0; i < submitterEmails.size(); i++) {
                if (courseCodes.contains(courseCode) && (submitterEmails.get(i)).contains(email)) {
                    System.out.println("Your scores are " + scores.get(i));

                    if (scores.get(submitterEmails.indexOf(email)) >= 85
                            && scores.get(submitterEmails.indexOf(email)) <= 100) {
                        System.out.println("Grade: A+");
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 80
                            && scores.get(submitterEmails.indexOf(email)) <= 84) {
                        System.out.println("Grade: A");
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 75
                            && scores.get(submitterEmails.indexOf(email)) <= 79) {
                        System.out.println("Grade: B+");
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 70
                            && scores.get(submitterEmails.indexOf(email)) <= 74) {
                        System.out.println("Grade: B");
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 65
                            && scores.get(submitterEmails.indexOf(email)) <= 69) {
                        System.out.println("Grade: C+");
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 60
                            && scores.get(submitterEmails.indexOf(email)) <= 64) {
                        System.out.println("Grade: C");
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 55
                            && scores.get(submitterEmails.indexOf(email)) <= 59) {
                        System.out.println("Grade: D+");
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 50
                            && scores.get(submitterEmails.indexOf(email)) <= 54) {
                        System.out.println("Grade: D");
                    } else if (scores.get(submitterEmails.indexOf(email)) >= 0
                            && scores.get(submitterEmails.indexOf(email)) <= 49) {
                        System.out.println("Grade: E");
                    }
                }
            }
        }
    }
}