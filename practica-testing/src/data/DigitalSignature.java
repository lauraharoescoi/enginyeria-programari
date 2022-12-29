package data;

import exceptions.DigitalSignatureException;

public class DigitalSignature {

    private final Byte[] signature;

    public DigitalSignature (Byte[] signature) { this.signature = signature; }

    public Byte[] getSignature () throws DigitalSignatureException {
        if (signature == null) throw new DigitalSignatureException();
        return signature;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature that = (DigitalSignature) o;
        return signature.equals(that.signature);
    }

    @Override
    public int hashCode () { return signature.hashCode(); }

    @Override
    public String toString () {
        return "DigitalSignature{" + "signature='" + signature + '\'' + '}';
    }
}
