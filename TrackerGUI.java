import javax.swing.*;
import java.text.DecimalFormat;

public class TrackerGUI {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        double buyingPrice = 0;
        double[] weekly = new double[7];
        double totalWeeklyEarnings = 0;

        // Entrada do preço de compra
        String buyingInput = JOptionPane.showInputDialog("Enter your buying price per share:");
        buyingPrice = Double.parseDouble(buyingInput);

        // Loop para cada dia da semana
        for (int i = 0; i < 7; i++) {
            String closingInput = JOptionPane.showInputDialog("Enter the closing price for day " + (i + 1) + ":");
            double closingPrice = Double.parseDouble(closingInput);
            double earnings = closingPrice - buyingPrice;
            weekly[i] = earnings;

            // Mensagem de resultado diário
            if (earnings > 0) {
                JOptionPane.showMessageDialog(null,
                        "After day " + (i + 1) + ", you have gained $" + df.format(earnings) + " per share.");
            } else if (earnings < 0) {
                JOptionPane.showMessageDialog(null,
                        "After day " + (i + 1) + ", you have lost $" + df.format(-earnings) + " per share.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "After day " + (i + 1) + ", you have no earnings per share.");
            }

            totalWeeklyEarnings += earnings;
        }

        // Exibe os ganhos semanais por dia e o total
        StringBuilder summary = new StringBuilder("Your weekly earnings:\n");
        for (int i = 0; i < weekly.length; i++) {
            summary.append("Day ").append(i + 1)
                    .append(": $").append(df.format(weekly[i])).append("\n");
        }

        summary.append("\nTotal earnings for the week: $").append(df.format(totalWeeklyEarnings));
        JOptionPane.showMessageDialog(null, summary.toString());
    }
}