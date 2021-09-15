#7. For each book authored (or co-authored) by "Stephen King", retrieve the title and the number of copies owned by the library branch whose name is "Central"
select title, noOfCopies
from ( ( (tbl_author natural join tbl_book) natural join tbl_book_copies)
natural join tbl_library_branch)
where tbl_author.authorName = 'Stephen King' and tbl_library_branch.branchName = 'Central'