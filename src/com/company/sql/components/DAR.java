package com.company.sql.components;

import java.sql.Timestamp;
import java.util.Random;

public class DAR {

    private String datafordelerOpdateringstid;
    private String forretningshandelse;
    private String forretningsomraade;
    private String forretningsproces;
    private String id_lokalId;
    private String id_namespace;
    private String navn;
    private String postnr;
    private String postnummerinddeling;
    private String registreringFra;
    private String registreringsaktor;
    private String status;
    private String virkningFra;
    private String virkningAktor;

    private DAR(Builder builder) {
        this.datafordelerOpdateringstid = builder.datafordelerOpdateringstid;
        this.forretningshandelse = builder.forretningshandelse;
        this.forretningsomraade = builder.forretningsomraade;
        this.forretningsproces = builder.forretningsproces;
        this.id_lokalId = builder.id_lokalId;
        this.id_namespace = builder.id_namespace;
        this.navn = builder.navn;
        this.postnr = builder.postnr;
        this.postnummerinddeling = builder.postnummerinddeling;
        this.registreringFra = builder.registreringFra;
        this.registreringsaktor = builder.registreringsaktor;
        this.status = builder.status;
        this.virkningFra = builder.virkningFra;
        this.virkningAktor = builder.virkningAktor;
    }

    // Implementing the builder pattern as we have a lot of fields.
    public static class Builder {

        private String datafordelerOpdateringstid;
        private String forretningshandelse;
        private String forretningsomraade;
        private String forretningsproces;
        private String id_lokalId;
        private String id_namespace;
        private String navn;
        private String postnr;
        private String postnummerinddeling;
        private String registreringFra;
        private String registreringsaktor;
        private String status;
        private String virkningFra;
        private String virkningAktor;

        public Builder setDatafordelerOpdateringstid(String datafordelerOpdateringstid) {
            this.datafordelerOpdateringstid = datafordelerOpdateringstid;
            Charset
            return this;
        }

        public Builder setForretningshandelse(String forretningshandelse) {
            this.forretningshandelse = forretningshandelse;
            return this;
        }

        public Builder setForretningsomraade(String forretningsomraade) {
            this.forretningsomraade = forretningsomraade;
            return this;
        }

        public Builder setForretningsproces(String forretningsproces) {
            this.forretningsproces = forretningsproces;
            return this;
        }

        public Builder setId_lokalId(String id_lokalId) {
            this.id_lokalId = id_lokalId;
            return this;
        }

        public Builder setId_namespace(String id_namespace) {
            this.id_namespace = id_namespace;
            return this;
        }

        public Builder setNavn(String navn) {
            this.navn = navn;
            return this;
        }

        public Builder setPostnr(String postnr) {
            this.postnr = postnr;
            return this;
        }

        public Builder setPostnummerinddeling(String postnummerinddeling) {
            this.postnummerinddeling = postnummerinddeling;
            return this;
        }

        public Builder setRegistreringFra(String registreringFra) {
            this.registreringFra = registreringFra;
            return this;
        }

        public Builder setRegistreringsaktor(String registreringsaktor) {
            this.registreringsaktor = registreringsaktor;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setVirkningFra(String virkningFra) {
            this.virkningFra = virkningFra;
            return this;
        }

        public Builder setVirkningAktor(String virkningAktor) {
            this.virkningAktor = virkningAktor;
            return this;
        }

        public DAR build() {
            return new DAR(this);
        }
    }

}
