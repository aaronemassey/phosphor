package edu.columbia.cs.psl.phosphor.struct;

import java.io.Serializable;
import java.util.Objects;


public abstract class LazyArrayIntTags implements Serializable {

	private static final long serialVersionUID = 7377241443004037122L;
	public int[] taints;

	public LazyArrayIntTags(int[] taints) {
		this.taints = taints;
	}

	public LazyArrayIntTags() {
	}

	public int lengthTaint;

	public int getLengthTaint() {
		return lengthTaint;
	}


	public abstract int getLength();
	public void setTaints(int tag) {
		if(taints == null)
			taints = new int[getLength()];
		for(int i = 0; i < taints.length; i++)
		{
			taints[i]=tag;
		}
	}

	public abstract Object getVal();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LazyArrayIntTags that = (LazyArrayIntTags) o;
		return Objects.equals(this.getVal(), that.getVal());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getVal());
	}
}
