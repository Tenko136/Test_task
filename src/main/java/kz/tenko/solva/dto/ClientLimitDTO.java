package kz.tenko.solva.dto;

public class ClientLimitDTO {
    private Long clientId;

    private String category;

    public ClientLimitDTO() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
