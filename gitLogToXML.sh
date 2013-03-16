#!/bin/sh

revlist=$(git rev-list --reverse HEAD)
(
	echo '<?xml version="1.0"?>'
	echo '<git>'
	declare -i id=0
	for rev in $revlist
	do
		echo "<commit id=$id>"

		files=$(git log -1 --pretty="format:" --name-only $rev)
		for file in $files
		do
			echo "	<file>$file</file>"
		done

		echo '</commit>'
		id+=1
	done

	echo '</git>'
) > out.xml

