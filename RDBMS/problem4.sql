#4.	For each book that is loaned out from the "Sharpstown" branch and whose DueDate is today, retrieve the book title, the borrower's name, and the borrower's address.
select title, name, address
from tbl_book
join tbl_book_loans
on tbl_book.bookId = tbl_book_loans.bookId
join tbl_borrower
on tbl_book_loans.cardNo = tbl_borrower.cardNo
join tbl_library_branch
on tbl_library_branch.branchId = tbl_book_loans.branchId
where tbl_library_branch.branchName = "Sharptown" and tbl_book_loans.dueDate = CURDATE();