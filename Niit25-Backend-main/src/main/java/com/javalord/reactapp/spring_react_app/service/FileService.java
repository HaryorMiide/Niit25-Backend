package com.javalord.reactapp.spring_react_app.service;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class FileService {

    public byte[] compressFileDeflater(byte[] file) {

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(file);
        deflater.finish();

        ByteArrayOutputStream stream = new ByteArrayOutputStream(file.length);
        byte[] dataHolder = new byte[4 * 1024];

        while (!deflater.finished()) {
            int size = deflater.deflate(dataHolder);
            stream.write(dataHolder, 0, size);
        }

        try {
            stream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return stream.toByteArray();
    }

    public byte[] deCompressFileDeflater(byte[] file) throws DataFormatException {

        Inflater inflater = new Inflater();
        inflater.setInput(file);

        ByteArrayOutputStream stream = new ByteArrayOutputStream(file.length);
        byte[] dataHolder = new byte[4 * 1024];

        while (!inflater.finished()) {
            int size = inflater.inflate(dataHolder);
            stream.write(dataHolder, 0, size);
        }

        try {
            stream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return stream.toByteArray();
    }

    public byte[] compressFileBase64(byte[] file) {



        return Base64.getEncoder().encode(file);
    }

    public byte[] deCompressFileBase64(byte[] file) {
        return Base64.getDecoder().decode(file);
    }
}