;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE

max:
;ouvbloc 6
enter 6,0
;iLoad
push word ptr [bp+6]

;iStore
pop ax
mov word ptr [bp-6],ax

;iLoad
push word ptr [bp-6]

;iLoad
push word ptr [bp+4]

;isup
pop bx
pop ax
cmp ax,bx
jle $+6
push -1
jmp $+4
push 0

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iLoad
push word ptr [bp-6]

;ireturn 8
pop ax
mov [bp+8],ax

;goto FSI1
jmp FSI1

SINON1:
;iLoad
push word ptr [bp+4]

;ireturn 8
pop ax
mov [bp+8],ax

FSI1:

;fermebloc 4
leave
ret 4

min:
;ouvbloc 0
enter 0,0
;iLoad
push word ptr [bp+6]

;iLoad
push word ptr [bp+4]

;iinf
pop bx
pop ax
cmp ax,bx
jge $+6
push -1
jmp $+4
push 0

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

;iLoad
push word ptr [bp+6]

;ireturn 8
pop ax
mov [bp+8],ax

;goto FSI2
jmp FSI2

SINON2:
;iLoad
push word ptr [bp+4]

;ireturn 8
pop ax
mov [bp+8],ax

FSI2:

;fermebloc 4
leave
ret 4

sup:
;ouvbloc 0
enter 0,0
;iLoad
push word ptr [bp+6]

;iLoad
push word ptr [bp+4]

;isup
pop bx
pop ax
cmp ax,bx
jle $+6
push -1
jmp $+4
push 0

;ireturn 8
pop ax
mov [bp+8],ax

;fermebloc 4
leave
ret 4

debut :
STARTUPCODE

main:
;ouvbloc 8
enter 8,0
;iConst
push word ptr 5

;iStore
pop ax
mov word ptr [bp-2],ax

;lireEnt
lea dx,[bp-4]
push dx
call lirent

;aLaLigne
call ligsuiv

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp-2]

;iLoad
push word ptr [bp-4]

;call max
call max

;iStore
pop ax
mov word ptr [bp-6],ax

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-6]

ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-8]

;ecrireBool
call ecrbool

;queue
nop
EXITCODE
end