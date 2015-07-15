package org.commcare.api.util;

import org.javarosa.core.util.externalizable.Hasher;
import org.javarosa.core.util.externalizable.PrototypeFactory;


/**
 * Most simple possible "hasher" - just gets the byte representation of the hash name
 *
 * @author wspride
 */
public class NameHasher implements Hasher {

    private final static int CLASS_HASH_SIZE = 8;

    @Override
    public byte[] getClassHashValue(Class type) {
        
        byte[] nameBytes = type.getName().getBytes();
        byte[] hash = new byte[CLASS_HASH_SIZE];

        System.arraycopy(nameBytes, 0, hash, 0, hash.length);

        byte[] badHash = new byte[]{0, 4, 78, 97};

        if (PrototypeFactory.compareHash(hash, nameBytes)) {
            System.out.println("BAD CLASS: " + type.getName());
        }

        return hash;
    }

    public int getHashSize(){
        return CLASS_HASH_SIZE;
    }
}
