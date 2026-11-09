package com.mycompany.enrollmentevaluator;
//Mari, Niel Cedrick P. BSCOME 1stYear Sir. Gole Programming
import java.util.Scanner;

public class EnrollmentEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================================");
        System.out.println("               UPHSD - STUDENT EVALUATOR (V. 1.0)");
        System.out.println("==========================================================");
        System.out.println("");

        System.out.println("SELECT APPLICANT CATEGORY:");
        System.out.println(" [1] Freshman Applicant");
        System.out.println(" [2] Transfer Applicant");
        System.out.println(" [3] Continuing Student");
        System.out.print("Enter Choice (1-3): ");
        int studentOption = scanner.nextInt();
        System.out.println("");

        switch (studentOption) {
            case 1:
                System.out.println("--- FRESHMAN APPLICANT EVALUATION ---");
                System.out.print("Enter High School GPA (1.00 - 5.00): ");
                double gpa = scanner.nextDouble();

                if (gpa < 1.00 || gpa > 5.00) {
                    System.out.println("[SYSTEM ERROR]: Invalid GPA Entered (" + gpa + ").");
                    System.out.println("GPA must be between 1.00 (Highest) and 5.00 (Failing).");
                    System.out.println("Evaluation terminated due to invalid input data.");
                    return;
                }

                System.out.print("Enter Entrance Exam Score (0.0 - 100.0): ");
                double examScore = scanner.nextDouble();

                if (examScore < 0.0 || examScore > 100.0) {
                    System.out.println("[SYSTEM ERROR]: Invalid Exam Score Entered (" + examScore + ").");
                    System.out.println("Evaluation terminated due to invalid input data.");
                    return;
                }

                System.out.print("Is Senior High School Track STEM? (1 = Yes, 2 = No): ");
                int stemChoice = scanner.nextInt();
                boolean isStem = (stemChoice == 1);

                String freshmanStatus = "";
                int freshmanUnits = 0;
                String freshmanReqs = "NONE";

                if (examScore < 60.0 || gpa > 3.00) {
                    freshmanStatus = "DENIED";
                    freshmanUnits = 0;
                    freshmanReqs = "DOES NOT MEET MINIMUM ADMISSION STANDARDS";
                } else if (gpa <= 2.00 && examScore >= 85.0) {
                    freshmanStatus = "REGULAR ADMISSION";
                    freshmanUnits = 24;
                } else if ((gpa >= 2.01 && gpa <= 2.75) || (examScore >= 75.0 && examScore <= 84.9)) {
                    freshmanStatus = "CONDITIONAL ADMISSION";
                    if (isStem && examScore >= 80.0) {
                        freshmanUnits = 21;
                        freshmanReqs = "SUBMIT ADVISING AGREEMENT (STEM LOAD UPGRADE)";
                    } else {
                        freshmanUnits = 18;
                        freshmanReqs = "SUBMIT ADVISING AGREEMENT";
                    }
                } else if (examScore >= 60.0 && examScore <= 74.9 && gpa <= 3.00) {
                    freshmanStatus = "PROBATIONARY ADMISSION";
                    freshmanUnits = 12;
                    freshmanReqs = "REMEDIAL WORKSHOP";
                }

                System.out.println("");
                System.out.println("EVALUATING APPLICANT DATA... PLEASE WAIT.");
                System.out.println("");
                System.out.println("---------------- EVALUATION RESULTS ----------------");
                System.out.println("Student Type            : Freshman Applicant");
                System.out.println("Academic Qualification  : GPA " + gpa + " | Exam Score: " + examScore);
                System.out.println("Admission Status        : " + freshmanStatus);
                System.out.println("Max Allowed Load        : " + freshmanUnits + " Credit Units");
                System.out.println("Requirements/Flags      : " + freshmanReqs);
                System.out.println("----------------------------------------------------");
                System.out.println("EVALUATION COMPLETE.");
                break;

            case 2:
                System.out.println("--- TRANSFER APPLICANT EVALUATION ---");
                System.out.print("Enter Total Transferable Units Earned: ");
                int unitsEarned = scanner.nextInt();

                if (unitsEarned < 0) {
                    System.out.println("[SYSTEM ERROR]: Invalid Units Entered (" + unitsEarned + ").");
                    System.out.println("Evaluation terminated due to invalid input data.");
                    return;
                }

                System.out.print("Enter Previous College GPA (1.00 - 5.00): ");
                double transferGpa = scanner.nextDouble();

                if (transferGpa < 1.00 || transferGpa > 5.00) {
                    System.out.println("[SYSTEM ERROR]: Invalid GPA Entered (" + transferGpa + ").");
                    System.out.println("GPA must be between 1.00 (Highest) and 5.00 (Failing).");
                    System.out.println("Evaluation terminated due to invalid input data.");
                    return;
                }

                System.out.print("Has Disciplinary Record? (1 = Yes, 2 = No): ");
                int recordChoice = scanner.nextInt();
                boolean hasDisciplinaryRecord = (recordChoice == 1);

                String transferStatus = "";
                int transferUnits = 0;
                String transferReqs = "NONE";

                if (hasDisciplinaryRecord) {
                    transferStatus = "ON HOLD - DISCIPLINARY";
                    transferUnits = 0;
                    transferReqs = "DISCIPLINARY CLEARANCE REQUIRED";
                } else if (unitsEarned < 15 || transferGpa > 2.75) {
                    transferStatus = "DENIED";
                    transferUnits = 0;
                    transferReqs = "DOES NOT MEET TRANSFER CRITERIA";
                } else if (unitsEarned >= 30 && transferGpa <= 2.25) {
                    transferStatus = "UNCONDITIONAL ACCEPTANCE";
                    transferUnits = 21;
                } else if ((unitsEarned >= 15 && unitsEarned <= 29 && transferGpa <= 2.50) || 
                           (unitsEarned >= 30 && transferGpa >= 2.26 && transferGpa <= 2.75)) {
                    transferStatus = "PROVISIONAL ACCEPTANCE";
                    transferUnits = 15;
                    transferReqs = "SUBMIT TOR";
                }

                System.out.println("");
                System.out.println("EVALUATING APPLICANT DATA... PLEASE WAIT.");
                System.out.println("");
                System.out.println("---------------- EVALUATION RESULTS ----------------");
                System.out.println("Student Type            : Transfer Applicant");
                System.out.println("Academic Qualification  : GPA " + transferGpa + " | Units: " + unitsEarned);
                System.out.println("Admission Status        : " + transferStatus);
                System.out.println("Max Allowed Load        : " + transferUnits + " Credit Units");
                System.out.println("Requirements/Flags      : " + transferReqs);
                System.out.println("----------------------------------------------------");
                System.out.println("EVALUATION COMPLETE.");
                break;

            case 3:
                System.out.println("--- CONTINUING STUDENT EVALUATION ---");
                System.out.print("Enter Current Cumulative GPA (1.00 - 5.00): ");
                double cGpa = scanner.nextDouble();

                if (cGpa < 1.00 || cGpa > 5.00) {
                    System.out.println("[SYSTEM ERROR]: Invalid GPA Entered (" + cGpa + ").");
                    System.out.println("GPA must be between 1.00 (Highest) and 5.00 (Failing).");
                    System.out.println("Evaluation terminated due to invalid input data.");
                    return;
                }

                System.out.print("Enter Current Unpaid Financial Balance ($): ");
                double updBalance = scanner.nextDouble();

                if (updBalance < 0.0) {
                    System.out.println("[SYSTEM ERROR]: Invalid Financial Balance Entered (" + updBalance + ").");
                    System.out.println("Evaluation terminated due to invalid input data.");
                    return;
                }

                System.out.print("Enter Academic Standing Status (1 = Good, 2 = Probation): ");
                int standingChoice = scanner.nextInt();
                boolean isGoodStanding = (standingChoice == 1);

                String contStatus = "";
                int contUnits = 0;
                String contReqs = "NONE";

                if (updBalance > 0.0) {
                    contStatus = "REGISTRATION HOLD - FINANCIAL";
                    contUnits = 0;
                    contReqs = "CLEAR OUTSTANDING BALANCE AT CASHIER BEFORE REGISTRATION";
                } else if (cGpa <= 1.50 && isGoodStanding) {
                    contStatus = "DEAN'S LIST";
                    contUnits = 27;
                } else if (cGpa >= 1.51 && cGpa <= 3.00) {
                    contStatus = "REGULAR ENROLLMENT";
                    contUnits = 21;
                } else if (cGpa > 3.00) {
                    contStatus = "PROBATIONARY ENROLLMENT";
                    contUnits = 12;
                    contReqs = "PROBATIONARY CONTRACT";
                }

                System.out.println("");
                System.out.println("EVALUATING APPLICANT DATA... PLEASE WAIT.");
                System.out.println("");
                System.out.println("---------------- EVALUATION RESULTS ----------------");
                System.out.println("Student Type            : Continuing Student");
                System.out.println("Academic Qualification  : GPA " + cGpa + " | Standing: " + (isGoodStanding ? "Good" : "Probation"));
                System.out.println("Unpaid Balance          : $" + String.format("%.2f", updBalance));
                System.out.println("Admission Status        : " + contStatus);
                System.out.println("Max Allowed Load        : " + contUnits + " Credit Units");
                System.out.println("Requirements/Flags      : " + contReqs);
                System.out.println("----------------------------------------------------");
                System.out.println("EVALUATION COMPLETE.");
                break;

            default:
                System.out.println("[SYSTEM ERROR]: Invalid Category Option Selected (" + studentOption + ").");
                System.out.println("Evaluation terminated due to invalid input data.");
                break;
        }
    }
}
/*
Code Explanation:

a.Condition Order: The code checks for wrong inputs first and stops right away using return;. It then checks for holds (Disciplinary for transfers, Unpaid Balance for continuing students) 
and failing grades before anything else because holds cancel enrollment, no matter how good the GPA is. After that, it checks from the best status down to the lowest (Dean's List - Regular - Probation).
b.Relational Operators: In the grading system, lower numbers are better grades. That is why gpa <= 2.00 means high grades,
while gpa > 3.00 means low or failing grades.
c.Logical Operators: && is used when a student must meet all rules at the same time (high GPA AND high exam score). 
|| is used for invalid inputs (GPA below 1.00 OR above 5.00) and automatic denials. its nested if is used to give extra units to STEM students
only after they qualify for conditional admission.

Reflection:

1. Critical Planning: Planning with pseudocode and flowcharts mapped out every decision path early, preventing logic mistakes and saving time before writing actual code.  
2. Condition Priority: Checking holds and invalid data first prevented unqualified or blocked students from mistakenly getting approved for full class units.  
3. Debugging Strat:Tracing the logic step-by-step using boundary values helped quickly spot inverted comparison signs and wrong logical operators. 
(Ginawa ko po sir I just chose ano sagutin dun ano po reflection ko sir)
*/

/*
answer
if (hasDisciplinaryRecord == true) {
    status = "ON HOLD";
    allowedUnits = 0;
} else if (unitsEarned >= 30 && collegeGPA <= 2.25) {
    status = "Unconditional Acceptance";
    allowedUnits = 21;
}
I just changed = to ==, changed || to && as it requires both to be accepted.
*/


//sir gole di na po ako naglagay ng example ung katulad sa baba na parang snippet parang d nmn po ata need thanks pooo for checking my code sir!


//do this 7:00pm
