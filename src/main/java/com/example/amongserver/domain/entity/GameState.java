package com.example.amongserver.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game_state")
public class GameState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "is_game_start")
    private boolean isGameStart;

    @Column(name = "is_game_pause")
    private boolean isGamePause;

    @OneToMany(mappedBy = "gameState")
    private List<User> users;

    public GameState(boolean isGameStart, boolean isGamePause, List<User> users) {
        this.isGameStart = isGameStart;
        this.isGamePause = isGamePause;
        this.users = users;
    }
}
