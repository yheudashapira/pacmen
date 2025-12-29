package view.panel_menu;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    public MainMenu(){
        // הגדר את מנהל הפריסה - BoxLayout מסדר רכיבים בטור או בשורה
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Y_AXIS לארגון אנכי

        // הוסף קצת ריווח פנימי מסביב לתפריט
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // הגדר צבע רקע לפאנל התפריט
        setBackground(new Color(50, 50, 50, 200));
        JLabel titleLabel = new JLabel("תפריט ראשי");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // גודל וסגנון גופן
        titleLabel.setForeground(Color.WHITE); // צבע טקסט
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // ממקם במרכז אופקי
        add(titleLabel); // הוסף את הכותרת לפאנל

// הוסף קצת רווח מתחת לכותרת
        add(Box.createRigidArea(new Dimension(0, 30)));

        String[] buttonLabels = {"התחל משחק", "התחל משחק עם תיעוד", "צפה במשחק שמור", "רשימת שיאים", "אפשרויות", "יציאה"};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 28));
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(70, 70, 70));
            button.setFocusPainted(false); // מבטל ציור ריבוע מסביב לכפתור כשמקבל פוקוס

            // הגדר יישור מרכזי עבור הכפתור בתוך ה-BoxLayout
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            // הגדר גודל מקסימלי כדי למנוע מהכפתורים להתפרס לרוחב מלא
            button.setMaximumSize(new Dimension(250, 60));

            add(button); // הוסף את הכפתור לפאנל

            // הוסף קצת רווח אחרי כל כפתור (למעט האחרון, אם תרצה)
            add(Box.createRigidArea(new Dimension(0, 15)));
        }
    }
}
