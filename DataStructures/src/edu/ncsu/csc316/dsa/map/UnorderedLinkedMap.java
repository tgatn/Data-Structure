package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * An unordered link-based map is an unordered (meaning keys are not used to
 * order entries) linked-memory representation of the Map abstract data type.
 * This link-based map delegates to an existing doubly-linked positional list.
 * To help self-organizing entries to improve efficiency of lookUps, the
 * unordered link-based map implements the move-to-front heuristic: each time an
 * entry is accessed, it is shifted to the front of the internal list.
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {

	/** positional list of entries */
	private PositionalList<Entry<K, V>> list;

	/**
	 * Constructor for UnorderedLinkedMap
	 */
	public UnorderedLinkedMap() {
		this.list = new PositionalLinkedList<Entry<K, V>>();
	}

	private Position<Entry<K, V>> lookUp(K key) {
		Position<Entry<K, V>> ret = null;
		Position<Entry<K, V>> look = list.first();
		for (Entry<K, V> e : list) {
			if (e.getKey().equals(key)) {
				ret = look;
			} else {
				look = list.after(look);
			}
		}
		return ret;
	}

	@Override
	public V get(K key) {
		Position<Entry<K, V>> p = lookUp(key);
		if (p == null) {
			return null;
		}
		V val = p.getElement().getValue();
		moveToFront(p);
		return val;
	}

	private void moveToFront(Position<Entry<K, V>> position) {
		list.addFirst(position.getElement());
		list.remove(position);
	}

	@Override
	public V put(K key, V value) {
		Position<Entry<K, V>> p = lookUp(key);
		// key exist
		if (p != null) {
			Entry<K, V> e = new MapEntry<>(key, value);

			V original = p.getElement().getValue();
			list.set(p, e);

			moveToFront(p);
			return original;
		} else { // key doesn't exist
			Entry<K, V> e = new MapEntry<>(key, value);
			list.addFirst(e);
			return null;
		}
	}

	@Override
	public V remove(K key) {
		Position<Entry<K, V>> p = lookUp(key);
		if (p == null) {
			return null;
		} else {
			V removeVal = p.getElement().getValue();
			list.remove(p);
			return removeVal;
		}
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		EntryCollection collection = new EntryCollection();
		for (Entry<K, V> entry : list) {
			collection.add(entry);
		}
		return collection;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("UnorderedLinkedMap[");
		Iterator<Entry<K, V>> it = list.iterator();
		while (it.hasNext()) {
			sb.append(it.next().getKey());
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}