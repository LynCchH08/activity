import java.util.Random;
import java.util.Scanner;

public class Try {

    // Method to generate a random 6-digit OTP
    public static String generateOTP() {
        Random rand = new Random();
        int otp = rand.nextInt(900000) + 100000; // Generates a 6-digit OTP
        return String.valueOf(otp);
    }

    // Method to simulate sending the OTP (printing to console for now)
    public static void sendOTP(String phoneNumber, String otp) {
        System.out.println("OTP sent to " + phoneNumber + ": " + otp); // Simulating SMS
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create an account by entering a phone number
        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();

        // Step 2: Generate OTP
        String otp = generateOTP();

        // Step 3: Simulate sending OTP to phone number
        sendOTP(phoneNumber, otp);

        // Step 4: Ask user to enter the OTP for verification
        System.out.println("Enter the OTP sent to your phone number for verification:");
        String enteredOTP = scanner.nextLine();

        // Step 5: Verify OTP
        if (enteredOTP.equals(otp)) {
            System.out.println("Account verified successfully!");
        } else {
            System.out.println("Incorrect OTP. Please try again.");
        }

        scanner.close();
    }
}
