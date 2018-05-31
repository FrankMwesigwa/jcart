package com.jcart.modules.tracker.branch;

import com.jcart.modules.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchController {

    @Autowired
    BranchRepository branchRepository;

    @GetMapping("/branch")
    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    @GetMapping("/branch/{id}")
    public Branch getBranch(@PathVariable(value = "id") Long branchId) {
        return branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch", "id", branchId));
    }

    @PostMapping("/branch")
    public Branch createBranch(@Valid @RequestBody Branch branch) {
        return branchRepository.save(branch);
    }

    @PutMapping("/branch/{id}")
    public Branch updateNote(@PathVariable(value = "id") Long branchId,
                             @Valid @RequestBody Branch branchDetails) {

        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch", "id", branchId));

        branch.setName(branchDetails.getName());

        Branch updatedNote = branchRepository.save(branch);
        return updatedNote;
    }

    @DeleteMapping("/branch/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long branchId) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch", "id", branchId));

        branchRepository.delete(branch);
        return ResponseEntity.ok().build();
    }

}
