#5.	For each library branch, retrieve the branch name and the total number of books loaned out from that branch.
select branchName, COUNT(*) as booksLoaned
from tbl_book_copies, tbl_library_branch
where tbl_book_copies.branchId = tbl_library_branch.branchId
group by tbl_library_branch.branchName;