package view.component;

import entity.leaderboard.LeaderboardEntry;
import interface_adapter.leaderboard.LeaderboardState;
import interface_adapter.leaderboard.LeaderboardViewState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Async Leaderboard Component
 */
public class LeaderboardComponent extends JPanel implements PropertyChangeListener {
    private final CardLayout loadingShowLayout = new CardLayout();
    private final JPanel loadingShowPanel = new JPanel(loadingShowLayout);
    private final ShowPanel showPanel;

    public LeaderboardComponent(LeaderboardViewState viewState) {

        showPanel = new ShowPanel(viewState.NAME_LABEL, viewState.SCORE_LABEL);
        showPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        loadingShowPanel.add(new LoadingPanel(), "loading");
        loadingShowPanel.add(showPanel, "show");
        this.add(loadingShowPanel);

        if (!viewState.getState().getLeaderboardEntries().isEmpty()) {
            showPanel.update(viewState.getState());
            loadingShowLayout.show(loadingShowPanel, "show");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName()) && evt.getSource() instanceof LeaderboardViewState) {
            LeaderboardState state = (LeaderboardState) evt.getNewValue();
            if (state.getLeaderboardEntries().isEmpty()) {
                loadingShowLayout.show(loadingShowPanel, "loading");
            } else {
                showPanel.update(state);
                loadingShowLayout.show(loadingShowPanel, "show");
            }
        } else {
            throw new RuntimeException("Leaderboard Component should never reach here");
        }
    }

    /**
     * Loading Panel (while still querying API)
     */
    private static class LoadingPanel extends JPanel {
        public LoadingPanel() {
            // To be replaced with a spinning gif
            JLabel title = new JLabel("Loading ◌");
            title.setFont(new Font("Arial", Font.PLAIN, 30));
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(title);
        }
    }

    /**
     * Panel for when leaderboard is shown
     */
    private static class ShowPanel extends JPanel {
        private final String name;
        private final String score;

        public ShowPanel(String name, String score) {
            setLayout(new GridLayout(11, 2));

            this.name = name;
            this.score = score;
        }

        /**
         * Update the view with updated state
         *
         * @param state .
         */
        public void update(LeaderboardState state) {
            this.removeAll();

            JLabel nameLabel = new JLabel(name);
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(nameLabel);

            JLabel scoreLabel = new JLabel(score);
            scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(scoreLabel);

            int i = 1;
            for (LeaderboardEntry entry : state.getLeaderboardEntries()) {
                JLabel username = new JLabel(i++ + ". " + entry.username());
                username.setFont(new Font("Arial", Font.PLAIN, 30));
                username.setHorizontalAlignment(SwingConstants.CENTER);
                JLabel score = new JLabel(String.valueOf(entry.score()));
                score.setFont(new Font("Arial", Font.PLAIN, 30));
                score.setHorizontalAlignment(SwingConstants.CENTER);

                this.add(username);
                this.add(score);
            }

            while (i < 11) {
                JLabel username = new JLabel(i++ + ". ");
                username.setFont(new Font("Arial", Font.PLAIN, 30));
                username.setHorizontalAlignment(SwingConstants.CENTER);

                this.add(username);
                this.add(new JLabel(""));
            }
        }
    }
}
