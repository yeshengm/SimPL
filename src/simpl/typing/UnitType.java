package simpl.typing;

final class UnitType extends Type {

    protected UnitType() {
    }

    @Override
    public boolean isEqualityType() {
        return false;
    }

    @Override
    public Substitution unify(Type t) throws TypeError {
        if (t instanceof TypeVar) {
            return t.unify(this);
        }
        if (t instanceof UnitType) {
            return Substitution.IDENTITY;
        }
        throw new TypeMismatchError(this, t);
    }

    @Override
    public boolean contains(TypeVar tv) {
        return false;
    }

    @Override
    public Type replace(TypeVar a, Type t) {
        return Type.UNIT;
    }

    @Override
    public boolean typeEquals(Type t) {
        return t instanceof UnitType;
    }

    public String toString() {
        return "unit";
    }
}
