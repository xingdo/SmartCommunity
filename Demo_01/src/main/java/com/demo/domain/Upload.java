package com.demo.domain;

public class Upload {
    private Long id;
    //文件名字
    private String filename;
    //文件路径
    private String filepath;

    public Long getId() {
        return id;
    }

    public Upload setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFilename() {
        return filename;
    }

    public Upload setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
        return this;
    }

    public String getFilepath() {
        return filepath;
    }

    public Upload  setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
        return this;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                '}';
    }

}