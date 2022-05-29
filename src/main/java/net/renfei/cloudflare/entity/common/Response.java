/*
 *   Copyright 2022 RenFei(i@renfei.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.renfei.cloudflare.entity.common;

import java.util.List;

/**
 * Response
 *
 * @author renfei
 */
public class Response<T> {
    private T result;
    private Boolean success;
    private List<Error> errors;
    private List<String> messages;
    private ResultInfo result_info;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public ResultInfo getResult_info() {
        return result_info;
    }

    public void setResult_info(ResultInfo result_info) {
        this.result_info = result_info;
    }

    public static class Error {
        private Integer code;
        private String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ResultInfo {
        private Integer page;
        private Integer per_page;
        private Integer count;
        private Integer total_count;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPer_page() {
            return per_page;
        }

        public void setPer_page(Integer per_page) {
            this.per_page = per_page;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getTotal_count() {
            return total_count;
        }

        public void setTotal_count(Integer total_count) {
            this.total_count = total_count;
        }

        @Override
        public String toString() {
            return "ResultInfo{" +
                    "page=" + page +
                    ", per_page=" + per_page +
                    ", count=" + count +
                    ", total_count=" + total_count +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", success=" + success +
                ", errors=" + errors +
                ", messages=" + messages +
                ", result_info=" + result_info +
                '}';
    }
}
