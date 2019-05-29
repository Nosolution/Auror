package org.seec.muggle.auror.vo.seatselection;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:09
 * @Version 1.0
 **/
public class SeatsSelectionForm {
    Long userId;
    Long sceneId;
    SelectionForm[] selectedSeats;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public SelectionForm[] getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(SelectionForm[] selectedSeats) {
        this.selectedSeats = selectedSeats;
    }
}
