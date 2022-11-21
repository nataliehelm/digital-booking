package com.grupo9.db.dto.Page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PageDto <T> {

    private Long pageQuantity;
    private String next;
    private String preview;
    private List<T> results;

    @JsonIgnore
    private Integer pageSize;
    @JsonIgnore
    private Integer pageNumber;

    public PageDto(Long pageQuantity, List<T> results, Integer pageSize, Integer pageNumber) {
        this.pageQuantity = pageQuantity;
        this.results = results;
        this.pageSize = pageSize==null ? 10 : pageSize;
        this.pageNumber = pageNumber==null ? 0 : pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setUrl(String requestUrl) {
        if (requestUrl==null) throw new InternalError("Invalid Url");

        String url = requestUrl.contains("?")?
                requestUrl.substring(0, requestUrl.indexOf("?")) : requestUrl;

        boolean nextPage = pageQuantity > ((Integer) this.pageNumber + this.pageSize);
        if (nextPage) {
            this.next = url + "?page=" + (this.pageNumber + 1) + "&size=" + this.pageSize;
        }

        boolean previewPage = pageQuantity > 0;
        if (previewPage) {
            this.preview = url + "?page=" + (this.pageNumber - 1) + "&size=" + this.pageSize;
        }
    }

}
